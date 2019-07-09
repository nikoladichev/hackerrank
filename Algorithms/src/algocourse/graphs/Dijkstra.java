package algocourse.graphs;

import com.sun.istack.internal.NotNull;

import java.util.*;

public class Dijkstra {

    private static class City implements Comparable<City> {
        int id;
        int value = Integer.MAX_VALUE;
        String name;

        Map<City, Integer> connectedCities = new HashMap<>();

        public City(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public City(int id, int value, String name) {
            this.id = id;
            this.value = value;
            this.name = name;
        }

        public Map<City, Integer> getConnectedCities() {
            return connectedCities;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            City city = (City) o;

            if (id != city.id) return false;
            if (value != city.value) return false;
            return name != null ? name.equals(city.name) : city.name == null;

        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + value;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public int compareTo(City o) {
            return this.value > o.value ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        City sofia = new City(0, 0, "Sofia");
        City plovdiv = new City(1, "Plovdiv");
        City burgas = new City(2, "Burgas");
        City pleven = new City(3, "Pleven");
        City varna = new City(4, "Varna");

        sofia.getConnectedCities().put(pleven, 3);
        sofia.getConnectedCities().put(plovdiv, 5);

        plovdiv.getConnectedCities().put(pleven, 1);
        plovdiv.getConnectedCities().put(burgas, 1);
        plovdiv.getConnectedCities().put(sofia, 5);

        burgas.getConnectedCities().put(plovdiv, 1);
        burgas.getConnectedCities().put(varna, 1);

        pleven.getConnectedCities().put(plovdiv, 1);
        pleven.getConnectedCities().put(varna, 2);
        pleven.getConnectedCities().put(sofia, 3);

        varna.getConnectedCities().put(burgas, 1);
        varna.getConnectedCities().put(pleven, 2);
        varna.getConnectedCities().put(plovdiv, 3);

        findShortestPath(sofia, burgas);
    }

    private static void findShortestPath(City start, City end) {

        City currentCity = start;
        Set<City> visitedCities = new HashSet<>();
        visitedCities.add(currentCity);

        Queue<City> queue = new PriorityQueue<>();

        do {

            currentCity.getConnectedCities().keySet().forEach(c -> {
                if (!visitedCities.contains(c)) {
                    queue.add(c);
                }
            });

            for (Map.Entry<City, Integer> entry: currentCity.getConnectedCities().entrySet()) {
                City city = entry.getKey();
                Integer value = entry.getValue();
                Integer cost = value + currentCity.value;

                if (!visitedCities.contains(city) && cost < city.value) {
                    city.value = cost;
                }
            }

            currentCity = queue.poll();
            visitedCities.add(currentCity);

        } while (!queue.isEmpty());

        System.out.println("Shortest path: " + end.value);
    }

}
