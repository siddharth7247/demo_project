package WorkManagerDemo

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class OneTimeWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        Thread.sleep(50000)
        Log.d("worker", "Task is completed in work manager!!")
        return Result.success()
    }
}
