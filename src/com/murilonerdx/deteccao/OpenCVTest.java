package com.murilonerdx.deteccao;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_COLOR;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;

public class OpenCVTest {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println(Core.VERSION);


        Mat imagemColorida = imread("src/com/murilonerdx/deteccao/opencv_java.jpg", CV_LOAD_IMAGE_COLOR);

        Util ut = new Util();

        ut.mostraImagem(ut.convertMatToImage(imagemColorida));

        Mat imagemCinza = new Mat();
        Imgproc.cvtColor(imagemColorida, imagemCinza, COLOR_BGR2GRAY);

        ut.mostraImagem(ut.convertMatToImage(imagemCinza));


    }
}
