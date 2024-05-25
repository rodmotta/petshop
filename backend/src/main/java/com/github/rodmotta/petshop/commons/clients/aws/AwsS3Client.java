package com.github.rodmotta.petshop.commons.clients.aws;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AwsS3Client {

    private final S3Client s3Client;

    public void uploadFile(MultipartFile file, String bucketName, String path) {

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(path)
                .build();

        try {
            RequestBody requestBody = RequestBody.fromBytes(file.getBytes());
            s3Client.putObject(putObjectRequest, requestBody);
        } catch (IOException e) {
            throw new RuntimeException(e); //todo: tratar
        }
    }
}
