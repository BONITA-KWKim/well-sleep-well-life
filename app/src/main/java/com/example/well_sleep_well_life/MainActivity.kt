package com.example.well_sleep_well_life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.R
import android.graphics.Color
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.components.YAxis

class MainActivity : AppCompatActivity() {

    private var lineChart: LineChart? = null
    private var barChart: BarChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* User space */


        /* Line graph test */
        lineChart = findViewById(R.id.line_chart) as LineChart

        val entries = ArrayList<Entry>()
        entries.add(Entry(1.0f, 1.0f))
        entries.add(Entry(2.0f, 2.0f))
        entries.add(Entry(3.0f, 0.0f))
        entries.add(Entry(4.0f, 4.0f))
        entries.add(Entry(5.0f, 3.0f))

        val lineDataSet = LineDataSet(entries, "Line graph dataset")
        lineDataSet.setLineWidth(4.0f)
        lineDataSet.setCircleRadius(6.0f)
        lineDataSet.setCircleColor(Color.parseColor("#FFA1B4DC"))
        lineDataSet.setCircleColorHole(Color.BLUE)
        lineDataSet.setColor(Color.parseColor("#FFA1B4DC"))
        lineDataSet.setDrawCircleHole(true)
        lineDataSet.setDrawCircles(true)
        lineDataSet.setDrawHorizontalHighlightIndicator(false)
        lineDataSet.setDrawHighlightIndicators(false)
        lineDataSet.setDrawValues(false)

        val lineData = LineData(lineDataSet)
        lineChart!!.setData(lineData)

        val xAxis = lineChart!!.getXAxis()
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.setTextColor(Color.BLACK)
        xAxis.enableGridDashedLine(8.0f, 24.0f, 0.0f)

        val yLAxis = lineChart!!.getAxisLeft()
        yLAxis.setTextColor(Color.BLACK)

        val yRAxis = lineChart!!.getAxisRight()
        yRAxis.setDrawLabels(false)
        yRAxis.setDrawAxisLine(false)
        yRAxis.setDrawGridLines(false)

        val description = Description()
        description.setText("description")

        lineChart!!.setDoubleTapToZoomEnabled(false)
        lineChart!!.setDrawGridBackground(false)
        lineChart!!.setDescription(description)
        lineChart!!.animateY(2000, Easing.EasingOption.EaseInCubic)
        lineChart!!.invalidate()

        /* bar graph test */
        barChart = findViewById(R.id.bar_chart) as BarChart

        val barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(1.0f, 1.0f))
        barEntries.add(BarEntry(2.0f, 2.0f))
        barEntries.add(BarEntry(3.0f, 0.0f))
        barEntries.add(BarEntry(4.0f, 4.0f))
        barEntries.add(BarEntry(5.0f, 3.0f))

        val barDataSet = BarDataSet(barEntries, "Bar graph dataset")
        barDataSet.setColors(Color.parseColor("#FFA1B4DC"))
        /*
        barDataSet.valueFormatter = object : ValueFormatter{
            fun getFormattedValue(value: Float, entry: Entry, dataSetIndex: Int,
                                  viewPortHandler: ViewPortHandler): String {
                return String.format("%d,%f", barEntries.indexOf(barEntries), value)
            }
        }
        */
        val barLabel = ArrayList<String>()
        barLabel.add("Test1")
        barLabel.add("Test2")
        barLabel.add("Test3")
        barLabel.add("Test4")
        barLabel.add("Test5")

        val barData = BarData(barDataSet)
        barChart!!.setData(barData)
        barChart!!.animateXY(1000, 1000)
        barChart!!.invalidate()
    }
}
