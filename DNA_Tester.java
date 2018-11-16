import java.util.ArrayList;

public class DNA_Tester
{
    public static void main(String... args) {
        boolean fittest = false;
        int populationSize = 10000;
        DNA[] population = new DNA[populationSize];
        DNA.target = "this is a string";

        for (int i = 0; i < population.length; i++) {
            population[i] = new DNA();
        }

        do{
            for (int i = 0; i < populationSize; i++) {
                population[i].fitness();
            }

            int index = 0;
            for(int i = 0; i < populationSize; i++)
            {
                if(population[i].fitness > population[index].fitness)
                    index = i;
            }

            if(population[index].fitness == 1.0f){
                fittest = true;
            }

            ArrayList<DNA> matingPool = new ArrayList<>();
            for (int i = 0; i < population.length; i++) {
                int n = (int) (populationSize * population[i].fitness);
                if(n > 9 * populationSize / 10)
                    n = 2 * populationSize / 10;
                else
                    n /= 3;
                for (int j = 0; j < n; j++) {
                    matingPool.add(population[i]);
                }
            }

            System.out.println("The most fit is DNA #" + mostFit(population));
            System.out.println();

            population = new DNA[populationSize];
            for (int i = 0; i < populationSize; i++) {
                int a = (int) (Math.random() * matingPool.size());
                int b = (int) (Math.random() * matingPool.size());

                DNA parentA = matingPool.get(a);
                DNA parentB = matingPool.get(b);

                DNA child = parentA.crossover(parentB);
                child.mutate();
                population[i] = child;
            }

        }while(!fittest);
    }

    public static String mostFit(DNA[] pop)
    {
        int index = 0;
        for(int i = 0; i < pop.length; i++)
        {
            if(pop[i].fitness > pop[index].fitness)
                index = i;
        }

        return index + " : " + new String(pop[index].genes);
    }
}

