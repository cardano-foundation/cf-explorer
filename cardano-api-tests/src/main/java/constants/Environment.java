package constants;

public class Environment {
    public static boolean isMainet() {
        return isValidEnv("mainet");
    }

    public static boolean isPreProd() {
        return isValidEnv("preprod");
    }

    private static boolean isValidEnv(String env) {
        return System.getProperty("cardanoAPI.baseEnv") != null ? System.getProperty("cardanoAPI.baseEnv").contains(env) : false;
    }
}
