package seedu.homerce.ui.financialpanel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import seedu.homerce.commons.core.LogsCenter;
import seedu.homerce.model.expense.Expense;
import seedu.homerce.model.revenue.Revenue;
import seedu.homerce.ui.UiPart;

/**
 * Controller for FinanceWindow.
 */
public class FinanceWindow extends UiPart<Stage> {
    private static final String FXML = "financialpanel/BreakdownFinancial.fxml";
    private static final Logger logger = LogsCenter.getLogger(FinanceWindow.class);

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

    /**
     * Creates a new FinanceWindow.
     *
     * @param root Stage to use as the root of the FinanceWindow.
     */
    public FinanceWindow(Stage root) {
        super(FXML, root);
    }

    /**
     * Creates a new FinanceWindow.
     */
    public FinanceWindow() {
        this(new Stage());
    }

    /**
     * Fills the data for the expense and revenue pie charts, and calculates the profit for the given month.
     *
     * @param expenseList the list of expenses for the month.
     * @param revenueList the list of revenue for the month.
     */
    public void construct(ObservableList<Expense> expenseList, ObservableList<Revenue> revenueList) {
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
                double newExpense = expense.getValue().value.doubleValue();
                maps.put(expense.getTag().tagName, newExpense);

            }
        }
        ObservableList<PieChart.Data> expenseChartData = maps.entrySet().stream()
            .map(expense -> new PieChart.Data(expense.getKey(), expense.getValue()))
            .collect(Collectors.toCollection(FXCollections::observableArrayList));

        expenseChart.setData(expenseChartData);
        expenseChart.setLegendVisible(false);
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
                double newRevenue = revenue.getValue().value.doubleValue();
                maps.put(revenue.getService().getTitle().value, newRevenue);
            }
        }
        ObservableList<PieChart.Data> revenueChartData = maps.entrySet().stream()
            .map(revenue -> new PieChart.Data(revenue.getKey(), revenue.getValue()))
            .collect(Collectors.toCollection(FXCollections::observableArrayList));

        revenueChart.setData(revenueChartData);
        revenueChart.setLegendVisible(false);
    }

    /**
     * Creates a profit display using the list of revenues and expenses.
     *
     * Revenue, expense and profit displays should be capped at 6 digits. Else it will overflow the container box.
     */
    private void setProfitDisplay(ObservableList<Expense> expenseList, ObservableList<Revenue> revenueList) {
        double totalExpense = expenseList
            .stream()
            .reduce(0.0, (sum, expense) -> sum + expense.getValue().value.doubleValue(), (
                sum, expenseAmount) -> sum + expenseAmount);
        double totalRevenue = revenueList
            .stream()
            .reduce(0.0, (sum, revenue) -> sum + revenue.getValue().value.doubleValue(), (
                sum, revenueAmount) -> sum + revenueAmount);
        double profit = totalRevenue - totalExpense;

        profitText.setText("Total Profit: $" + String.valueOf(profit));
        expenseText.setText("Total Expense: $" + String.valueOf(totalExpense));
        revenueText.setText("Total Revenue: $" + String.valueOf(totalRevenue));
    }

    /**
     * Shows the finance window.
     *
     * @throws IllegalStateException <ul>
     *                               <li>
     *                               if this method is called on a thread other than the JavaFX Application
     *                               Thread.
     *                               </li>
     *                               <li>
     *                               if this method is called during animation or layout processing.
     *                               </li>
     *                               <li>
     *                               if this method is called on the primary stage.
     *                               </li>
     *                               <li>
     *                               if {@code dialogStage} is already showing.
     *                               </li>
     *                               </ul>
     */
    public void show() {
        logger.fine("Showing finance page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the finance window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the finance window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the finance window.
     */
    public void focus() {
        getRoot().requestFocus();
    }
}
