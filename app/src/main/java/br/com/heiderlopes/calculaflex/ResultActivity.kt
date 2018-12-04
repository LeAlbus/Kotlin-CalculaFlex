package br.com.heiderlopes.calculaflex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.heiderlopes.calculaflex.extension.format
import kotlinx.android.synthetic.main.activity_form.view.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        calculate()
    }

    private fun calculate() {
        val gasPrice = intent.extras.getDouble("GAS_PRICE", 1.0)
        val gasAverage = intent.extras.getDouble("GAS_AVERAGE", 1.0)
        val ethanolPrice = intent.extras.getDouble("ETHANOL_PRICE", 1.0)
        val ethanolAverage = intent.extras.getDouble("ETHANOL_AVERAGE", 1.0)

        val performanceMyCar = ethanolAverage/gasAverage
        val priceIndice = ethanolPrice/gasPrice

        if(priceIndice <= performanceMyCar){
            tvSuggestion.text = getString(R.string.label_ethanol)
        } else {
            tvSuggestion.text = getString(R.string.label_gasoline)
        }

        tvGasAverageResult.text = (gasPrice/gasAverage).format(2)
        tvEthanolAverageResult.text = (ethanolPrice/ethanolAverage).format(2)

        tvFuelRatio.text = getString(R.string.label_ratio_fuel, performanceMyCar.format(2))
    }

}
