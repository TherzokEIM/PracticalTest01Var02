package ro.pub.cs.systems.eim.practicaltest01var02;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var02Service extends Service {
    private ProcessingThread processingThread = null;

    public PracticalTest01Var02Service() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        processingThread = new ProcessingThread(this);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }
}

