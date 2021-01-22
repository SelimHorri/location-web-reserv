package com.salim.location.pack.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtilImpl implements ReportUtil {
// Begin Class
	
	@Override
	public void generatePieChart(String path, List<Object[]> data) {
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for (Object[] objs : data) {
			dataset.setValue(objs[0].toString(), new Double(objs[1].toString()));
		}
		
		JFreeChart chart = ChartFactory.createPieChart3D("Location Type Report", dataset);
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/pieChart.jpeg"), chart, 700, 500);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
// End Class
}
