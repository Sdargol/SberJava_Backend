package org.sdargol.vehicles.manager;

@FunctionalInterface
public interface ICommand {
    void execute(IManager manager);
}
