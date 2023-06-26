/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.gregl.utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author dnlbe & albert
 */
public class IconUtils {

    private IconUtils() {
    }

    public static ImageIcon createIcon(File file, int width, int height) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(file);
        Image image = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    public static ImageIcon scaleImageToHeight(ImageIcon imageIcon, int maxHeight) {
        Image image = imageIcon.getImage();

        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        if (imageHeight > maxHeight) {
            // Calculate the new width to maintain the aspect ratio
            int scaledWidth = (int) ((double) imageWidth * ((double) maxHeight / imageHeight));
            image = image.getScaledInstance(scaledWidth, maxHeight, Image.SCALE_SMOOTH);
        }

        return new ImageIcon(image);
    }

}
