package com.murilonerdx.deteccao;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_COLOR;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;

public class Exemplo1 {

    //Não esqueça de jogar como PARAM VM em execução -Djava.library.path="D:\opencv\build\java\x64";
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println(Core.VERSION);

        Mat imagemColorida = imread("pessoas/pessoas4.jpg");
        Mat imagemCinza = new Mat();

        Imgproc.cvtColor(imagemColorida, imagemCinza, COLOR_BGR2GRAY);

        CascadeClassifier classificador =
                new CascadeClassifier("cascades/haarcascade_frontalface_default.xml");
        MatOfRect facesDetectadas = new MatOfRect();
        classificador.detectMultiScale(imagemCinza,
                facesDetectadas,
                1.4,
                1,
                0,
                new Size(30,30),
                new Size(100,100));

        System.out.println(facesDetectadas.toArray().length);

        //Matriz, começa na posição x e começa na posição y
        for(Rect rect : facesDetectadas.toArray()){
            System.out.println(rect.x + " " + rect.y + " " + rect.width + " " + rect.height);
            //Desenhar um retangulo
            //Ponto inicial e final, scalar é a cor e thickness é a borda
            Imgproc.rectangle(imagemColorida, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0,0, 255), 2);
        }

        Util ut = new Util();
        ut.mostraImagem(ut.convertMatToImage(imagemColorida));


    }
}
