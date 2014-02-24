package liquibase.database.core.supplier;

import java.util.Map;

public class PostgresqlConnSupplierWindows extends PostgresqlConnSupplier {

    @Override
    public String getConfigurationName() {
        return "windows";
    }

    @Override
    public String getVersion() {
        return "9.3.2-3";
    }

    public String getInstallDir() {
        return "C:\\pgsql-"+getShortVersion();
    }

    @Override
    public ConfigTemplate getPuppetTemplate(Map<String, Object> context) {
        return new ConfigTemplate("liquibase/sdk/vagrant/supplier/postgresql/postgresql-windows.puppet.vm", context);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n"+
                "Install Dir: "+getInstallDir()+"\n" +
                "REQUIRES: LIQUIBASE_HOME/sdk/vagrant/install-files/windows/vcredist_64.exe. Download Microsoft Visual C++ 2010 Redistributable Package (x64) from http://www.microsoft.com/en-us/download/confirmation.aspx?id=14632\n"+
                "REQUIRES: LIQUIBASE_HOME/sdk/vagrant/install-files/postgresql/postgresql-"+getVersion()+"-windows-x64-binaries.zip. Download Win x86-64 archive from http://www.enterprisedb.com/products-services-training/pgbindownload\n"+
                "Admin 'postgres' user password: "+getAdminPassword();
    }
}
