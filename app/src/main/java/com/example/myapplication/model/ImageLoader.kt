import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class ImageLoader(private val imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {

    override fun doInBackground(vararg urls: String): Bitmap? {
        val imageUrl = urls[0]
        var bitmap: Bitmap? = null
        var inputStream: InputStream? = null
        var connection: HttpURLConnection? = null

        try {
            val url = URL(imageUrl)
            connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            inputStream = connection.inputStream
            bitmap = BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            connection?.disconnect()
            inputStream?.close()
        }
        return bitmap
    }

    override fun onPostExecute(result: Bitmap?) {
        result?.let {
            imageView.setImageBitmap(result)
        }
    }
}
