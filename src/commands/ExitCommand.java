package commands;

import cache.StoreCache;

import java.util.List;

public class ExitCommand implements Command{

    @Override
    public void execute(String[] args, StoreCache cache) {
        System.out.println("Exiting the application...");
        System.exit(0);
    }
}
