package commands;


import java.util.HashMap;
import java.util.Map;

public class CommandMap {
    private final Map<String, Command> commands;

    public CommandMap() {
        commands = new HashMap<>();
        commands.put("save_product", new SaveProductCommand());
        commands.put("purchase_product", new PurchaseProductCommand());
        commands.put("order_product", new OrderProductCommand());
        commands.put("get_quantity_of_product", new GetQuantityOfProductCommand());
        commands.put("get_average_price", new GetAveragePriceCommand());
        commands.put("get_product_profit", new GetProductProfitCommand());
        commands.put("get_fewest_product", new GetFewestProductCommand());
        commands.put("get_most_popular_product", new GetMostPopularProductCommand());
        commands.put("get_orders_report", new GetOrdersReportCommand());
        commands.put("export_orders_report", new ExportOrdersReportCommand());
        commands.put("exit", new ExitCommand());

    }

    public Command getCommand(String commandString) {
        return commands.get(commandString);
    }
}

