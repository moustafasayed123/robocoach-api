package com.nike.robocoach.robocoachapi.service.impl;

import com.nike.robocoach.robocoachapi.controller.UploadImageController;
import com.nike.robocoach.robocoachapi.exception.BusinessException;
import com.nike.robocoach.robocoachapi.model.Coordinate;
import com.nike.robocoach.robocoachapi.model.RequestModel;
import com.nike.robocoach.robocoachapi.model.ResponseModel;
import com.nike.robocoach.robocoachapi.service.UploadImageServiceApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadImageServiceImpl implements UploadImageServiceApi {
    private static final Logger logger = LogManager.getLogger(UploadImageServiceImpl.class);
    @Override
    public ResponseModel sendToCVModel(RequestModel requestModel) throws BusinessException {

        /* call aws lambda providing 'requestModel.getImage()' string value */

        List<Coordinate> athleteCoordinates = new ArrayList<>();
        athleteCoordinates.add(new Coordinate(1.1, 4.5));
        athleteCoordinates.add(new Coordinate(1.1, 3.5));

        List<Coordinate> userCoordinates = new ArrayList<>();
        userCoordinates.add(new Coordinate(2.5, 4.5));
        userCoordinates.add(new Coordinate(5.6, 3.5));

        return new ResponseModel(requestModel.getFrameIndex(), athleteCoordinates, userCoordinates, 56.7);
    }

/*    private void processImageNotUsed(File ff) throws Exception {

       *//* try {
            File convFile = new File(file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            return convFile;


            nu.pattern.OpenCV.loadShared();
            File f = null;
            f = new File("posenet_mobilenet_v1_100_257x257_multi_kpt_stripped.tflite");
            System.out.println("hello");
            Mat m = Imgcodecs.imread(ff.getName());
            int rowsNumber = m.rows();
            int colsNumber = m.cols();
            System.out.println(m.empty());
            //  int rgb[] = new int[3];
            double matrix[][][] = new double[rowsNumber][colsNumber][3];
            for (int i = 0; i < rowsNumber; i++) {
                for (int j = 0; j < colsNumber; j++) {

                    double rgb[] = m.get(i, j);
                    matrix[i][j] = rgb;
                    // System.out.println(rgb[0]);
                }
            }
            System.out.println(matrix);
            loadModel(matrix);
        } catch (Exception e) {
            throw new Exception(e);
        }*//*

        //  System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        //Interpreter interpreter = new Interpreter("file");
        //interpreter.ru
    }


    private void loadModel(double input[][][]) throws Exception {
     *//*   try {

            File f = new File("/Users/msayed/pb/mobilenet_v1_100_257x257_multi_kpt_stripped.tflite");
            Interpreter interpreter = new Interpreter(f);

            SavedModelBundle savedModelBundle = SavedModelBundle.load("/Users/msayed/demo_model");
            System.out.println("hhh");
        } catch (Exception e) {
            throw new Exception(e);
        }
*//*


    *//*    try (SavedModelBundle savedModelBundle = SavedModelBundle.load("/Users/msayed/pb")) {

            try (Session session = savedModelBundle.session()) {
                Session.Runner runner = session.runner();
                runner.feed("x", Tensor.create(10));
                runner.feed("y", Tensor.create(20));

                List<Tensor<?>> tensors = runner.fetch("ans").run();
                System.out.println("Answer is: " + tensors.get(0).intValue());
            }

        } catch (TensorFlowException ex) {
            ex.printStackTrace();
        }*//*

    }*/
}

