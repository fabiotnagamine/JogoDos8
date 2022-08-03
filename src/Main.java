import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {

    static final long MEGABYTE_FACTOR = 1024L * 1024L;

    public static void main(String[] args) {
        System.out.println("Starting DFS to solve 8-puzzle");

        //long start = System.currentTimeMillis();
        LocalDateTime startTime = LocalDateTime.now();
        DFS bfs = new DFS("1","2","3","8","0","4","7","6","5");
        boolean success = bfs.Resolver();
        LocalDateTime endTime = LocalDateTime.now();

        if(success)
        {
            System.out.println("\t\t\tStatistics:");
            System.out.println("Movimentos para completar o onjetivo: " + bfs.GetNoAtual().GetCaminhoObjetivo());
            System.out.println("Custo do algoritmo: " + bfs.GetNoAtual().GetcustoCaminho());
            System.out.println("Nós expandidos: "+bfs.GetNoExplorado().size());
            System.out.println("Busca em profundidade: " + bfs.GetNoAtual().GetSearchDepth());
            System.out.println("Max Search depth: " + bfs.GetNoAtual().GetMaxSearchDepth());


            //long hours = startTime.until( endTime, ChronoUnit.HOURS);
            long seconds = startTime.until( endTime, ChronoUnit.SECONDS);
            if(seconds == 0)
            {
                long milliSeconds = startTime.until( endTime, ChronoUnit.MILLIS);
                System.out.println("running time:  "+ milliSeconds+" MILLISECONDS");
            }
            else
            {
                System.out.println("running time:  "+ seconds+" SECONDS");
            }
            final long MEGABYTE_FACTOR = 1024L * 1024L;
            final DecimalFormat ROUNDED_DOUBLE_DECIMALFORMAT;
            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
            otherSymbols.setDecimalSeparator('.');
            otherSymbols.setGroupingSeparator(',');
            ROUNDED_DOUBLE_DECIMALFORMAT = new DecimalFormat("####0.00", otherSymbols);
            ROUNDED_DOUBLE_DECIMALFORMAT.setGroupingUsed(false);
            double totalMiB = bytesToMiB(getUsedMemory());
            System.out.println(String.format("Max memory usage: %s Megabytes", totalMiB)); ;

        }
        else
        {
            System.err.println("Solução não encontrada!");
        }


    }
    public static long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    private static double bytesToMiB(long bytes) {
        return ((double) bytes / MEGABYTE_FACTOR);
    }

    public static long getMaxMemory() {
        return Runtime.getRuntime().maxMemory();
    }

    public static long getUsedMemory() {
        return getTotalMemory() - getFreeMemory();
    }


    public static long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }

}
