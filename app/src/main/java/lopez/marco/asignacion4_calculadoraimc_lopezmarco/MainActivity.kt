package lopez.marco.asignacion4_calculadoraimc_lopezmarco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etKilos:EditText=findViewById(R.id.editTextKilos) as EditText
        val etEstatura:EditText=findViewById(R.id.editTextEstatura) as EditText
        val tvImc:TextView=findViewById(R.id.imc) as TextView
        val tvRange:TextView=findViewById(R.id.range) as TextView
        val botonCalcular:Button=findViewById(R.id.botonCalcular) as Button
//        val avatar: ImageView =findViewById(R.id.avatar) as ImageView

        botonCalcular.setOnClickListener{
            val resultImc=this.calcularIMC(etEstatura.text.toString().toDouble(),etKilos.text.toString().toDouble())
            tvImc.setText(resultImc.toString())
            val estado=this.obtenerEstado(resultImc)
            tvRange.setText(estado)
            when(estado){
                "Bajo peso" -> tvRange.setBackgroundResource(R.color.colorGreenish)
                "Normal" -> tvRange.setBackgroundResource(R.color.colorGreen)
                "Sobrepeso" -> tvRange.setBackgroundResource(R.color.colorYellow)
                "Obesidad grado 1" -> tvRange.setBackgroundResource(R.color.colorOrange)
                "Obesidad grado 2" -> tvRange.setBackgroundResource(R.color.colorRed)
                "Obesidad grado 3" -> tvRange.setBackgroundResource(R.color.colorBrown)
            }
        }
    }

    fun calcularIMC(altura:Double, peso:Double):Double{
        val imc:Double=(peso/Math.pow(altura,2.0))
        return imc
    }

    fun obtenerEstado(imc:Double):String{
        when{
            imc < 18.5 -> return "Bajo peso"
            imc <= 24.9 -> return "Normal"
            imc <= 29.9 -> return "Sobrepeso"
            imc <= 34.9 -> return "Obesidad grado 1"
            imc <= 39.9 -> return "Obesidad grado 2"
            imc >= 40 -> return "Obesidad grado 3"
        }
        return "ERROR"
    }

}