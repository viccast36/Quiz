package com.example.quizpop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {
    int practice;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //should be quizactivity
        setContentView(R.layout.ranking_activity);


        //TextView blah = findViewById(R.id.textView2);
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);

        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();
        //get user names and scores here. have to normalize data from 1 to 100 before inputing value
        data.add(new ValueDataEntry("user1", 80));
        data.add(new ValueDataEntry("user2", 94));
        data.add(new ValueDataEntry("user3", 10));
        data.add(new ValueDataEntry("user4", 61));
        data.add(new ValueDataEntry("user5", 16));
        data.add(new ValueDataEntry("user6", 40));
        data.add(new ValueDataEntry("user7", 70));
        data.add(new ValueDataEntry("user8", 21));
        data.add(new ValueDataEntry("user9", 49));

        Column column = cartesian.column(data);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("User Ranking");

        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("User");
        cartesian.yAxis(0).title("Score");

        anyChartView.setChart(cartesian);
    }

    public double normalize(int userScore)
    {
        //do stuff
        double num= 2.2;
        return num;
    }

}
