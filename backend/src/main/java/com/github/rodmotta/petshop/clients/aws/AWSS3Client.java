package com.github.rodmotta.petshop.clients.aws;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Component
public class AWSS3Client {

    private final AmazonS3 s3Client;

    public AWSS3Client(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public void uploadFile(MultipartFile multipartFile, String bucketName, String path) {
        File file = null;
        try {
            file = convertMultipartfileToFile(multipartFile);
            s3Client.putObject(bucketName, path, file);
        } catch (Exception e) {
            e.printStackTrace();//todo - loggar erro
        } finally {
            if (file != null) {
                file.delete();
            }
        }
    }

    private File convertMultipartfileToFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;
    }

    public String getFileUrl(String bucketName, String path) {
        return s3Client.getUrl(bucketName, path).toString();
    }
}
