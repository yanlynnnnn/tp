package seedu.homerce.ui.financialpanel;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

import seedu.homerce.model.expense.Expense;
import seedu.homerce.model.revenue.Revenue;
import seedu.homerce.ui.UiPart;

public class FinancialPanel extends UiPart<Region> {

    public static final String TAB_NAME = "Financials";
    private static final String FXML = "financialpanel/BreakdownFinancial.fxml";
    private ObservableList<Expense> expenseList;
    private ObservableList<Revenue> revenueList;

    @FXML
    private PieChart revenueChart;

    @FXML
    private PieChart expenseChart;

    @FXML
    private Text profitText;

    @FXML
    private Text expenseText;

    @FXML
    private Text revenueText;



    public FinancialPanel(ObservableList<Expense> expenseList, ObservableList<Revenue> revenueList) {
        super(FXML);
        this.expenseList = expenseList;
        this.revenueList = revenueList;
    }

    public void construct() {
        setExpenseChart(expenseList);
        setRevenueChart(revenueList);
        setProfitDisplay(expenseList, revenueList);
        
    }

    /**
     * Creates a pie chart based on the tags in the given list of expenses.
     *
     * In order for the chart to show only expenses for a particular month, the list of expenses need to be filtered
     * to only include expenses within that month.
     */
    private void setExpenseChart(ObservableList<Expense> expenseList) {
        Map<String, Double> maps = new HashMap<>();
        for (Expense expense : expenseList) {
            if (maps.containsKey(expense.getTag().tagName)) {
                double currentExpense = maps.get(expense.getTag().tagName);
                double newExpense = currentExpense + expense.getValue().value.doubleValue();
                maps.put(expense.getTag().tagName, newExpense);

            } else {
                double newExpense =  expense.getValue().value.doubleValue();
                maps.put(expense.getTag().tagName, newExpense);

            }
        }
        ObservableList<PieChart.Data> expenseChartData = maps.entrySet().stream()
            .map(expense -> new PieChart.Data(expense.getKey(), expense.getValue()))
            .collect(Collectors.toCollection(FXCollections::observableArrayList));

        expenseChart.setData(expenseChartData);
    }

    /**
     * Creates a pie chart based on the Services in the given list of revenues.
     *
     * In order for the chart to show only revenues for a particular month, the list of revenues need to be filtered
     * to only include revenues within that month.
     */
    private void setRevenueChart(ObservableList<Revenue> revenueList) {
        Map<String, Double> maps = new HashMap<>();
        for (Revenue revenue : revenueList) {
            if (maps.containsKey(revenue.getService().getTitle().value)) {
                double currentRevenue = maps.get(revenue.getService().getTitle().value);
                double newRevenue = currentRevenue + revenue.getValue().value.doubleValue();
                maps.put(revenue.getService().getTitle().value, newRevenue);

            } else {
                double newRevenue =  revenue.getValue().value.doubleValue();
                maps.put(revenue.getService().getTitle().value, newRevenue);
            }
        }
        ObservableList<PieChart.Data> revenueChartData = maps.entrySet().stream()
            .map(revenue -> new PieChart.Data(revenue.getKey(), revenue.getValue()))
            .collect(Collectors.toCollection(FXCollections::observableArrayList));

        revenueChart.setData(revenueChartData);
    }

    /**
     * Creates a profit chart using the list of revenues and expenses.
     */
    private void setProfitDisplay(ObservableList<Expense> expenseList, ObservableList<Revenue> revenueList) {
        // Revenue, expense and profit displays are capped at 6 digits. Else it will overflow the container box.
        profitText.setText("Total profits: " + "2,000,000");
        expenseText.setText("Total expenses: " + "200,000");
        revenueText.setText("Total revenue: " + "20");
    }
}
