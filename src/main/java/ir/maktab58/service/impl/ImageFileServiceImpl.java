package ir.maktab58.service.impl;

import ir.maktab58.data.entities.ImageFile;
import ir.maktab58.data.enums.ImageType;
import ir.maktab58.data.repository.ImageFileRepository;
import ir.maktab58.dto.users.ExpertDto;
import ir.maktab58.service.interfaces.ImageFileService;
import ir.maktab58.service.mapper.interfaces.ExpertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.font.MultipleMaster;
import java.io.*;

/**
 * @author Taban Soleymani
 */
@Service
public class ImageFileServiceImpl implements ImageFileService {
    @Autowired
    private ImageFileRepository imageFileRepository;

    @Autowired
    private ExpertMapper expertMapper;

    public ImageFile saveNewImage(String name, ImageType profile, MultipartFile multipartFile, ExpertDto expert) {
        try (InputStream initialStream = multipartFile.getInputStream();) {
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);
            File targetFile = new File("C:\\Users\\Taban\\Desktop\\maktab\\service_provider_system\\src\\main\\resources\\" + name + ".png");
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
            ImageFile profileImg = ImageFile.builder().withName(name)
                    .withType(profile).withImage(buffer).build();
            return imageFileRepository.save(profileImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
