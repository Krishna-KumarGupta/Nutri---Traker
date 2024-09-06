package com.Springpro.Spring.service;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.LuminanceSource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class BarcodeScannerService {

    public String scanBarcode(InputStream inputStream) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        MultiFormatReader reader = new MultiFormatReader();
        Map<DecodeHintType, Object> hints = new HashMap<>();
        hints.put(DecodeHintType.POSSIBLE_FORMATS, java.util.Arrays.asList(
                com.google.zxing.BarcodeFormat.CODE_128,
                com.google.zxing.BarcodeFormat.QR_CODE
        ));
        reader.setHints(hints);

        Result result = reader.decode(bitmap);
        return result.getText();
    }

    private static class BufferedImageLuminanceSource extends LuminanceSource {
        private final byte[] luminances;

        public BufferedImageLuminanceSource(BufferedImage image) {
            super(image.getWidth(), image.getHeight());
            final int width = image.getWidth();
            final int height = image.getHeight();
            final byte[] rgb = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
            luminances = new byte[width * height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int offset = y * width + x;
                    int rgbValue = rgb[offset] & 0xFF;
                    luminances[offset] = (byte) rgbValue;
                }
            }
        }

        @Override
        public byte[] getRow(int y, byte[] row) {
            if (row == null || row.length < getWidth()) {
                row = new byte[getWidth()];
            }
            System.arraycopy(luminances, y * getWidth(), row, 0, getWidth());
            return row;
        }

        @Override
        public byte[] getMatrix() {
            return luminances;
        }
    }
}
