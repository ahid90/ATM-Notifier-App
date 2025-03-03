import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val urlInput = findViewById<EditText>(R.id.url_input)
        val atmInput = findViewById<EditText>(R.id.atm_input)
        val startButton = findViewById<Button>(R.id.start_button)

        startButton.setOnClickListener {
            val atmUrl = urlInput.text.toString()
            val targetATM = atmInput.text.toString()
            if (atmUrl.isNotEmpty() && targetATM.isNotEmpty()) {
                scheduleATMCheck(this, atmUrl, targetATM)
                Toast.makeText(this, "تم تفعيل مراقبة الصراف", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "يرجى إدخال الرابط واسم الصراف", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
