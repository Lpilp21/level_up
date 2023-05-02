package program;

import cache.StoreCache;
import commands.Command;
import commands.CommandMap;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StoreCache cache = new StoreCache();
        CommandMap commandMap = new CommandMap();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("--> ");
            String input = scanner.nextLine();

            String[] tokens = input.split("\\s+");
            String commandString = tokens[0];
            String[] inArgs = Arrays.copyOfRange(tokens, 1, tokens.length);
            executeCommand(commandString, inArgs, cache, commandMap);
            if (commandString.equals("exit")) {
                break;}
        }
        scanner.close();
        System.exit(0);
    }
    public static void executeCommand(String commandString, String[] args, StoreCache cache, CommandMap commandMap) {
        Command command = commandMap.getCommand(commandString);
        if (command == null) {
            System.out.println("Invalid command.");
            return;
        }
        try {
            command.execute(args, cache);
        } catch (Exception e) {
            System.out.println("An error occurred while executing the command: " + e.getMessage());
        }
    }


}