package com.github.rodmotta.petshop.commons.clients.aws;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.io.IOException;
import java.time.Duration;

@Component
@RequiredArgsConstructor
public class AwsS3Client {

    private final S3Client s3Client;

    public void uploadFile(MultipartFile file, String bucketName, String path, String contentType) {

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(path)
                .contentType(contentType)
                .build();

        try {
            RequestBody requestBody = RequestBody.fromBytes(file.getBytes());
            s3Client.putObject(putObjectRequest, requestBody);
        } catch (IOException e) {
            throw new RuntimeException(e); //todo: tratar
        }
    }

    public String getFileUrl(String bucketName, String path) {

        GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder()
                .getObjectRequest(builder -> builder
                        .bucket(bucketName)
                        .key(path)
                        .build())
                .signatureDuration(Duration.ofMinutes(10))
                .build();

        S3Presigner s3Presigner = S3Presigner.builder()
                .region(Region.SA_EAST_1)
                .s3Client(s3Client)
                .build();

        return s3Presigner.presignGetObject(getObjectPresignRequest)
                .url()
                .toString();
    }
}
