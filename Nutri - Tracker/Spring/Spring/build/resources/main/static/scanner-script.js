document.addEventListener('DOMContentLoaded', () => {
    const backButton = document.getElementById('back-button');
    const scannerPreview = document.getElementById('scanner-preview');
    const codeReader = new ZXing.BrowserMultiFormatReader();

    backButton.addEventListener('click', () => {
        window.location.href = 'index.html';
    });

    function startScanning() {
        codeReader.listVideoInputDevices()
            .then(videoInputDevices => {
                if (videoInputDevices.length > 0) {
                    const firstDeviceId = videoInputDevices[0].deviceId;
                    codeReader.decodeOnceFromVideoDevice(firstDeviceId, 'scanner-preview')
                        .then(result => {
                            const barcode = result.text;
                            window.location.href = `/details.html?barcode=${barcode}`;
                        })
                        .catch(err => {
                            console.error('Scan Error:', err);
                        });
                } else {
                    console.error('No video input devices found');
                }
            })
            .catch(err => {
                console.error('Error accessing video devices:', err);
            });
    }

    startScanning();
});
