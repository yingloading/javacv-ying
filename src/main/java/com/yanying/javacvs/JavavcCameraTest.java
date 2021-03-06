package com.yanying.javacvs;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import javax.swing.*;

public class JavavcCameraTest {

//    public static void main(String[] args) throws Exception, InterruptedException{
//        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
//        grabber.start();   //开始获取摄像头数据
//        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
//        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        canvas.setAlwaysOnTop(true);
//        while(true){
//            if(!canvas.isDisplayable()){//窗口是否关闭
//                grabber.stop();//停止抓取
//                System.exit(2);//退出
//                break;
//            }
//            canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
//            Thread.sleep(200);//50毫秒刷新一次图像
//        }
//    }

    public static void main(String[] args) throws FrameGrabber.Exception, InterruptedException {
//        FFmpegFrameGrabber fg = new FFmpegFrameGrabber("E:\\dow\\file\\download\\ffmpeg\\bin\\1.mp4");
        FFmpegFrameGrabber fg = new FFmpegFrameGrabber("rtmp://localhost:1935/live/home");
        fg.start();

        CanvasFrame canvas = new CanvasFrame("摄像头");

        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas.setAlwaysOnTop(true);

        while(true){
            if(!canvas.isDisplayable()){//窗口是否关闭
                fg.stop();//停止抓取
                System.exit(2);//退出
                break;
            }
            canvas.showImage(fg.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
//            Thread.sleep(23);//50毫秒刷新一次图像
        }
    }

}
