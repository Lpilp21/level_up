package commands;

import cache.StoreCache;

import java.util.List;

public interface Command {
    void execute(String[] args, StoreCache cache);
}
