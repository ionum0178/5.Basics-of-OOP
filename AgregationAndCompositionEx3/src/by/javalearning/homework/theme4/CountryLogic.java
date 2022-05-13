package by.javalearning.homework.theme4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryLogic {

    private File file;
    private List<Region> regions = new ArrayList<Region>();

    private Town town;
    private String twnName;
    private String regName;
    private String distrName;

    private List<District> districts = new ArrayList<District>();

    public Country newCountry() throws FileNotFoundException {
	file = new File("./src/resourse/brest.txt");
	initRegions(file);

	file = new File("./src/resourse/vitebsk.txt");
	initRegions(file);

	file = new File("./src/resourse/gomel.txt");
	initRegions(file);

	file = new File("./src/resourse/grodno.txt");
	initRegions(file);

	file = new File("./src/resourse/minsk.txt");
	initRegions(file);

	file = new File("./src/resourse/mogilev.txt");
	initRegions(file);

	return new Country("Республика Беларусь", 207000, new Town("Минск"), regions);

    }

    @SuppressWarnings({ "resource" })
    private void initRegions(File file) throws FileNotFoundException {
	Scanner sc = new Scanner(file).useDelimiter("\\r\\n");
	regName = sc.nextLine();
	twnName = sc.nextLine();
	town = new Town(twnName);
	while (sc.hasNextLine()) {
	    distrName = sc.nextLine();
	    districts.add(new District(distrName));
	    continue;
	}

	regions.add(new Region(regName, town, new ArrayList<District>(districts)));
	districts.clear();
    }

}
