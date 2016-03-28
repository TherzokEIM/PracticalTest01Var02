package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by therzok on 28/03/16.
 */
public class ProcessingThread extends Thread {
    private Context context = null;
    private boolean isRunning = true;
    private Random rand = new Random();

    public ProcessingThread(Context context) {

    }

    @Override
    public void run() {
        while (isRunning) {
            sendMessage();
            sleep();
        }
    }

    private void sendMessage() {
        ArrayList<Integer> values = new ArrayList<Integer> ();
        for (int i = 0; i < 4; ++i)
            values.add(rand.nextInt());
        Intent intent = new Intent();
        intent.setAction("GET_NUMBERS");
        intent.putIntegerArrayListExtra("values", values);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
