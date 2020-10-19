package seedu.homerce.ui.financialpanel;

import java.net.URL;

import javax.swing.plaf.synth.Region;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import seedu.homerce.model.expense.Expense;
import seedu.homerce.model.revenue.Revenue;
import seedu.homerce.ui.UiPart;

public class FinancialPanel extends UiPart<Region> {

    public static final String TAB_NAME = "Financials Tab";
    private static final String FXML = "financialpanel/BreakdownFinancial.fxml";

    @FXML
    private PieChart revenueChart;

    @FXML
    private PieChart expenseChart;

    @FXML
    private BarChart<?, ?> profitChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;


    public FinancialPanel(ObservableList<Expense> expenseList, ObservableList<Revenue> revenueList) {
        super(FXML);
        setExpenseChart(expenseList);
        setRevenueChart(revenueList);
        setProfitChart(expenseList, revenueList);

    }

    private void setExpenseChart(ObservableList<Expense> expenseList) {
        ObservableList<PieChart.Data> expenseChartData = FXCollections.observableArrayList(
            new PieChart.Data("Hair", 15),
            new PieChart.Data("Fixed", 45.1),
            new PieChart.Data("Towel", 25.9),
            new PieChart.Data("Ingredients", 10)
        );

        expenseChart.setData(expenseChartData);

    }

    private void setRevenueChart(ObservableList<Revenue> revenueList) {
        ObservableList<PieChart.Data> revenueChartData = FXCollections.observableArrayList(
            new PieChart.Data("Hair Blow", 45.9),
            new PieChart.Data("Lash lift", 37.5),
            new PieChart.Data("Manicure", 23),
            new PieChart.Data("Hair Treatment", 80)
        );

        revenueChart.setData(revenueChartData);

    }

    private void setProfitChart(ObservableList<Expense> expenseList, ObservableList<Revenue> revenueList) {
        XYChart.Series set = new XYChart.Series<>();

        set.getData().add(new XYChart.Data("August", 200));
        set.getData().add(new XYChart.Data("September", 490));

        profitChart.getData().addAll(set);
    }
}
