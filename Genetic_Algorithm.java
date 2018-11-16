public interface Genetic_Algorithm
{
    void fitness();
    void mutate();
    Genetic_Algorithm crossover(Genetic_Algorithm parent);
}
