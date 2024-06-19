/**
 * @author 33319
 * @Description
 * @create 2024/6/18 23:35
 */
package org.example.controller;

import org.example.pojo.Result;
import org.example.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //把文件存贮到本地磁盘
        String originalFilename = file.getOriginalFilename();
        //保证文件名唯一
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        //文件存储路径
        String url = AliOssUtil.uploadFile(filename, file.getInputStream());
        return Result.success(url);
    }
}
