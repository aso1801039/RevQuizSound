package jp.ac.asojuku.revquizsound

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {


    private var m_Spool = SoundPool(4, AudioManager.STREAM_MUSIC, 0)

    private var m_idpoolPresent: Int = 0
    private var m_idpoolWrong: Int = 0
    private var m_idpoolCorrect: Int = 0
    private var m_idpoolHakushu: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        // 出題
        val btnPresen = findViewById(R.id.btnPresen) as Button
        m_idpoolPresent = m_Spool.load(this, R.raw.present, 1)
        btnPresen.setOnClickListener {
            // 音をならす
            m_Spool.play(m_idpoolPresent, 0.3f, 0.3f, 0, 0, 1.0f)
        }
        // まちがい
        val btnWrong = findViewById(R.id.btnWrong) as Button
        m_idpoolWrong = m_Spool.load(this, R.raw.incorrect1, 1)
        btnWrong.setOnClickListener {
            // 音をならす
            m_Spool.play(m_idpoolWrong, 0.4f, 0.4f, 0, 0, 1.0f)
        }
        // せいかい
        val btnCorrect = findViewById(R.id.btnCorrect) as Button
        m_idpoolCorrect = m_Spool.load(this, R.raw.correct1, 1)
        btnCorrect.setOnClickListener {
            // 音をならす
            m_Spool.play(m_idpoolCorrect, 0.4f, 0.4f, 0, 0, 1.0f)
        }
        // はくしゅ
        val btnHakushu = findViewById(R.id.btnHakushu) as Button
        m_idpoolHakushu = m_Spool.load(this, R.raw.people_cheer1, 1)
        btnHakushu.setOnClickListener {
            // 音をならす
            m_Spool.play(m_idpoolHakushu, 0.4f, 0.4f, 0, 0, 1.0f)
        }
    }


    fun onPresentClick(view: View) {
        val intent = Intent(this, QuestionActivity::class.java)
        startActivity(intent)
    }

    override fun onPause() {
        super.onPause()
        m_Spool.release()
    }


    fun onAnsClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
