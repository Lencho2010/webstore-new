package com.geoway.webstore;

import com.geoway.webstore.config.MinioConfig;
import io.minio.*;
import io.minio.errors.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RunWith(SpringRunner.class)
@SpringBootTest
class WebstoreServerApplicationTests {

    @Autowired
    private MinioConfig minioConfig;
    @Autowired
    private MinioClient minioClient;

    @Test
    public void testUploadFile2Minio() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {

        File inputFile = new File("d:/test/110106.mdb");
        InputStream inputStream = new FileInputStream(inputFile);
        String fileName = inputFile.getName();
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileName)
                .stream(inputStream, inputFile.length(), -1)
                .build();
        ObjectWriteResponse objectWriteResponse = minioClient.putObject(args);

        String retUrl = minioConfig.getUrl() + "/" + minioConfig.getBucketName() + "/" + fileName;
        System.out.println(retUrl);

        // 检查存储桶是否已经存在
        /*BucketExistsArgs bucket = BucketExistsArgs.builder().bucket("second").build();
        boolean isExist = minioClient.bucketExists(bucket);
        if (isExist) {
            System.out.println("Bucket already exists.");
        } else {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket("second").build());
        }*/

    }

    /*public String uploadFile(MultipartFile file) throws Exception
    {
        String fileName = FileUploadUtils.extractFilename(file);
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileName)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType())
                .build();
        client.putObject(args);
        return minioConfig.getUrl() + "/" + minioConfig.getBucketName() + "/" + fileName;
    }*/

}
