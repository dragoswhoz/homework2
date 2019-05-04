package tema_23_03;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

import java.nio.MappedByteBuffer;

public class Streams {

	public static class NotImplementedException extends RuntimeException {
		public NotImplementedException() {
			super("This method hasn't been implemented yet!");
		}
	}

	public static List<Integer> returnSquareRoot(List<Integer> numbers) {
		List<Integer> sqrtNumbers = numbers.stream()
			.map(n -> (int) Math.sqrt(n))
			.collect(Collectors.toList());
		return sqrtNumbers;
	}

	public static List<Integer> getAgeFromUsers(List<User> user) {
		List<Integer> ageFromUser = user.stream()
			.map(User::getAge)
			.collect(Collectors.toList());
		return ageFromUser;
	}

	public static List<Integer> getDistinctAges(List<User> users) {
		List<Integer> listOfDistinctAges = getAgeFromUsers(users).stream()
							.distinct()
							.collect(Collectors.toList());
		return listOfDistinctAges;
	}

	public static List<User> getLimitedUserList(List<User> users, int limit) {
		List<User> limited = users.stream()
								.limit(limit)
								.collect(Collectors.toList());
		return limited;
	}

	public static Integer countUsersOlderThen25(List<User> users) {
		return (int) users.stream()
			.filter(u -> {return (u.getAge() > 25);})
			.count();
	}

	public static List<String> mapToUpperCase(List<String> strings) {
		List<String> upperCase = strings.stream()
										.map(String::toUpperCase)
										.collect(Collectors.toList());
		return upperCase;
	}

	public static Integer sum(List<Integer> integers) {
		Integer sum = integers.stream()
				.mapToInt(a -> a)
				.sum();
		return sum;
	}

	public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
		List<Integer> skipped = integers.stream()
				.skip(toSkip)
				.collect(toList());
		return skipped;
	}

	public static List<String> getFirstNames(List<String> names) {
		Function<String, String> mappingFunction = s ->{return (s.split("\\s")[0]);};
		List<String> firstNames = names.stream()
			.map(mappingFunction)
			.collect(Collectors.toList());
		return firstNames;
	}

	public static List<String> getDistinctLetters(List<String> names) {
		String string = names.stream().reduce(String::concat).get();
		return Arrays.asList(string.split("")).stream()
											.distinct()
											.collect(toList());
	}

	public static String separateNamesByComma(List<User> users) {
		//BinaryOperator <String> bo = (s1,s2) -> {return String.join(", ", s1, s2);};
			return users.stream()
			.map(User::getName)
			.reduce((s1,s2) -> String.join(", ", s1, s2)).get();
	}

	public static double getAverageAge(List<User> users) {
		double averageAge = users.stream()
			.mapToDouble(User::getAge)
			.average().getAsDouble();
		return averageAge;
	}

	public static Integer getMaxAge(List<User> users) {
		int maxAge = users.stream()
			.mapToInt(User::getAge)
			.max()
			.getAsInt();
		
		return maxAge;
	}

	public static Integer getMinAge(List<User> users) {
		int minAge = users.stream()
				.mapToInt(User::getAge)
				.min()
				.getAsInt();
		
			return minAge;
	}

	public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
		Map<Boolean, List<User>> userByGender = users.stream()
													.collect(Collectors.groupingBy(User::isMale));
		return userByGender;
	}

	public static Map<Integer, List<User>> groupByAge(List<User> users) {
		Map<Integer, List<User>> usersByAge = users.stream()
			.collect(Collectors.groupingBy(User::getAge));
		return usersByAge;
	}

	public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
		Map<Boolean, Map<Integer, List<User>>> collect = users.stream()
				.collect(Collectors.groupingBy(User::isMale, Collectors.groupingBy(User::getAge)));
		return collect;
	}

	public static Map<Boolean, Long> countGender(List<User> users) {
		return users.stream().collect(Collectors.groupingBy(User::isMale, Collectors.counting()));
	}

	public static boolean anyMatch(List<User> users, int age) {
		return users.stream()
					.anyMatch(u -> u.getAge() == age);
	}

	public static boolean noneMatch(List<User> users, int age) {
		return users.stream()
				.noneMatch(u -> u.getAge()== age);
	}

	public static Optional<User> findAny(List<User> users, String name) {
		return users.stream()
				.filter(u -> u.getName().equalsIgnoreCase(name))
				.findAny();
	}

	public static List<User> sortByAge(List<User> users) {
		return users.stream()
				.sorted((u1,u2) -> u1.getAge() - u2.getAge())
				.collect(toList());
	}

	public static Stream<Integer> getBoxedStream(IntStream stream) {
		return stream.boxed();
	}

	public static List<Integer> generateFirst10PrimeNumbers() {
		return IntStream.iterate(2, n -> n+1)
						.filter(Streams::isPrime)
						.limit(10)
						.boxed()
						.collect(toList());
	}

	public static boolean isPrime(int number) {
		return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}

	public static List<Integer> generate10RandomNumbers() {
		Random random = new Random();
		return random.ints().limit(10)
				.boxed()
				.collect(toList());
				
	}

	public static User findOldest(List<User> users) {
		return users.stream()
				.sorted((u1,u2) -> u2.getAge() - u1.getAge())
				.findFirst()
				.get();
	}

	public static int sumAge(List<User> users) {
		return users.stream()
				.mapToInt(User::getAge)
				.sum();
	}

}
