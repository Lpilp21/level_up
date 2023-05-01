package commands;

import cache.StoreCache;

import java.io.IOException;
import java.util.List;

public interface Command {
    void execute(String[] args, StoreCache cache) throws IOException;
}
