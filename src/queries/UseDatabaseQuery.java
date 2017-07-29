package queries;

import Model.IQuery;
import Model.Result;
import QueryParser.DatabaseHelper;
import common.Utils;

import java.io.File;

public class UseDatabaseQuery implements IQuery {
    public String databaseName;

    public UseDatabaseQuery(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public Result ExecuteQuery() {
        DatabaseHelper.CurrentDatabaseName = this.databaseName;
        System.out.println("Database changed");
        return null;
    }

    @Override
    public boolean ValidateQuery() {
        boolean databaseExists = DatabaseHelper.DatabaseExists(this.databaseName);
        if(!databaseExists){
            Utils.printError(String.format("Unknown database '%s'", this.databaseName));
        }

        return databaseExists;
    }
}
