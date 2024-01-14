package com.herman87.demogenerateqrcode.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.herman87.demogenerateqrcode.domain.Student;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QrCodeGenerator {

    public static void generateQrCode(Student student) throws WriterException, IOException {
        var qrcodePath = "/home/essoungou_wonga/Downloads/demo-generate-qrcode/src/main/resources/static/qrcode";
        var qrcodeName = qrcodePath
                .concat(student.getFirstname().concat(student.getId().toString()))
                .concat("-QRCODE.png");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID: "+student.getId()+ "\n",
                BarcodeFormat.QR_CODE,
                400,
                400);

        Path path = FileSystems.getDefault().getPath(qrcodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }
}
