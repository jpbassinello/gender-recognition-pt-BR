package br.com.jpb;

import java.text.Normalizer;
import java.util.*;

public class GenderRecognitionPtBr {

	private static final Map<Character, LetterExceptionRule> EXCEPTION_RULES_BY_CHAR;

	static {
		EXCEPTION_RULES_BY_CHAR = new HashMap<>();
		EXCEPTION_RULES_BY_CHAR.put('a', new LetterExceptionRule('b', Gender.FEMALE, asSet("bliw", "br", "civ", "clim",
				"diem", "dnar", "du", "err", "fa", "h|", "hc", "ho", "hpa", "htan", "ile|", "iledr", "imer", "ja", "jr",
				"ka", "kk", "la|", "lg", "lit", "liv", "loc", "lro", "man", "may", "mini", "mlaj", "mn", "mru", "muz",
				"ng", "nnat", "np", "om", "raj", "rat", "raug", "rieb", "riev", "rik", "riu", "rp", "ruj", "rum", "rut",
				"sa", "ssa", "ssu", "tai|", "tano", "tari", "tel", "terp", "toj", "tsi", "ua", "ud", "uh", "uq", "va",
				"vd", "vi|", "vlis", "vo", "vr", "w", "yan", "zuo")));
		EXCEPTION_RULES_BY_CHAR.put('b', new LetterExceptionRule('b', Gender.MALE, asSet("adani")));
		EXCEPTION_RULES_BY_CHAR.put('c', new LetterExceptionRule('c', Gender.MALE, asSet("il", "it")));
		EXCEPTION_RULES_BY_CHAR.put('d', new LetterExceptionRule('d', Gender.MALE, asSet("ade", "ir")));
		EXCEPTION_RULES_BY_CHAR.put('e', new LetterExceptionRule('e', Gender.FEMALE, asSet("ad", "aj", "ak", "bao", "bu",
				"cal", "ced", "cilef", "ciru", "cn", "curb", "dad", "deb", "di|", "dia|", "diat", "dic", "dila", "div",
				"dla", "dlih", "dlinesa", "dn", "do", "el", "g|", "ge", "go", "gr", "gu", "hp", "ib", "ile", "ill", "in",
				"j", "ke", "ki", "klo", "kn", "ko", "ks", "ku", "lat", "lau", "lav", "lc", "ledr", "leg", "leit", "len",
				"less", "leu", "lh", "libat", "lil", "lir", "lled", "lo", "ly", "ma", "mea", "med", "mi", "ml", "mr", "ms",
				"mu", "my", "nahp", "nan", "navi", "navla", "navle", "navlig", "navo", "ned", "neico", "neit", "nelig",
				"nelsu", "ner|", "niav", "niaw", "nidla", "nidu", "nim", "nin", "nio", "nitr", "nnav", "nner", "nnh",
				"nnoi", "noc", "nod", "noe", "nof", "noice", "noicla", "noide", "noih", "noj", "nor", "not", "nr", "nu",
				"oi", "on", "pe", "pi", "po", "pp", "py", "ras", "rb", "rd", "reb", "red", "rf", "ria", "rih", "ro", "rr",
				"rt", "sd", "se", "sieg", "sliw", "soj", "sr", "sse", "ssu", "su", "tea", "tedlaw", "tedoi", "teds", "teia",
				"tesin", "teze", "tezin", "tided", "tiu", "tl", "tna", "tne", "tra", "treal", "treh", "trei", "tser", "ua",
				"ug", "uo", "uqa", "uqe", "uqia", "uqini", "uqir", "uql", "uqo", "uqr", "use", "uso", "uzo", "vat", "vi",
				"vo", "w", "y", "z|", "za", "ze", "zu")));
		EXCEPTION_RULES_BY_CHAR.put('f', new LetterExceptionRule('f', Gender.MALE, asSet()));
		EXCEPTION_RULES_BY_CHAR.put('g', new LetterExceptionRule('g', Gender.MALE, asSet("ie", "neh", "nipm", "nob", "nuj")));
		EXCEPTION_RULES_BY_CHAR.put('h', new LetterExceptionRule('h', Gender.MALE, asSet("ak", "an", "ar", "s", "teb", "ter",
				"tes", "tezil", "tezir", "tide|", "tidu", "tur")));
		EXCEPTION_RULES_BY_CHAR.put('i', new LetterExceptionRule('i', Gender.MALE, asSet("ale", "ana", "ano", "ba", "cajd",
				"calg", "caram", "cari|", "carid", "carol", "cedli", "cen|", "cia", "cira", "cle|", "cn", "co", "cu", "dak",
				"diel", "dir", "duh", "elrih", "elris", "em|", "enir", "ha", "j|", "ki", "kusi", "kuy|", "lag", "lar", "legn",
				"lei", "lek", "lel", "len", "les", "leu", "lev", "lez", "li", "lleh", "llek", "lra", "lrednaw", "mah", "mei",
				"meo", "mor", "mt", "muss", "muy", "muz", "nab", "nai", "nari", "nas", "nat", "naul", "nav|", "navi|", "navli",
				"nay", "ne|", "nec", "neg", "nel", "neru", "neso|", "nev", "nez", "nic", "nie", "nil", "nnej", "nom", "nu",
				"ram", "rev", "rh", "roa", "ruya", "sl", "sr", "sseg", "tor", "ts", "tter", "tteu", "ua", "vai", "z|", "zaz", "zus")));
		EXCEPTION_RULES_BY_CHAR.put('j', new LetterExceptionRule('j', Gender.MALE, asSet()));
		EXCEPTION_RULES_BY_CHAR.put('k', new LetterExceptionRule('k', Gender.MALE, asSet("an", "l")));
		EXCEPTION_RULES_BY_CHAR.put('l', new LetterExceptionRule('l', Gender.MALE, asSet("am", "eb|", "ebam", "ebar", "ebas",
				"ebaz", "ehca", "eht", "euq", "iag", "inel", "lem", "o")));
		EXCEPTION_RULES_BY_CHAR.put('m', new LetterExceptionRule('m', Gender.MALE, asSet("ailil", "air", "aiv", "arim", "ee",
				"eleu", "em", "er")));
		EXCEPTION_RULES_BY_CHAR.put('n', new LetterExceptionRule('n', Gender.MALE, asSet("ailil", "aillil", "airam", "airi",
				"airy", "aivi", "ale", "alir", "asu", "avin", "avira", "ayri", "azu", "eho", "ekc", "ele", "ell", "em",
				"era", "ets", "ielr", "ilek", "ilev", "ims", "ir", "itsi", "itsr", "na|", "ny", "orah", "uk", "us", "y")));
		EXCEPTION_RULES_BY_CHAR.put('o', new LetterExceptionRule('o', Gender.MALE, asSet("acie", "ce", "cim", "cit", "d|",
				"h|", "ico", "ka", "ke", "kiek", "kies", "kihc", "kihs", "kika", "kiku", "kim", "kir", "kit", "ko", "kur",
				"kus", "kuy", "kuzi", "leu", "nats", "niruam", "rro", "tej", "tnem", "ul")));
		EXCEPTION_RULES_BY_CHAR.put('p', new LetterExceptionRule('p', Gender.MALE, asSet("iy")));
		EXCEPTION_RULES_BY_CHAR.put('q', new LetterExceptionRule('q', Gender.MALE, asSet()));
		EXCEPTION_RULES_BY_CHAR.put('r', new LetterExceptionRule('r', Gender.MALE, asSet("al", "amal", "amaz", "amicy",
				"amidi", "amidue", "amilo", "amisl", "amizl", "amsire", "anide", "effi", "efi", "ehta", "ehts", "epse",
				"etse|", "iadam", "ialce", "ialo", "ian|", "icalg", "idan|", "idel", "inav|", "inave|", "inec|", "inele",
				"inez", "inoi", "oif", "onoe", "ycar")));
		EXCEPTION_RULES_BY_CHAR.put('s', new LetterExceptionRule('s', Gender.MALE, asSet("adinu", "aitak", "ecr", "edec",
				"edio", "edlia", "edred", "edru", "eduel", "edui", "egri", "ekl", "eleg", "enele", "eng", "eni|", "enia",
				"enid|", "enir", "ep", "ered", "erim|", "erima", "ero", "even", "iah", "ial", "iat", "ida", "ila", "ile|",
				"ili", "ill", "ily", "inedl", "inna", "io", "ira", "irc|", "iri|", "irim", "iris", "irod", "iry", "isi",
				"itr", "iz", "orieh", "yd", "yni", "yr")));
		EXCEPTION_RULES_BY_CHAR.put('t', new LetterExceptionRule('t', Gender.MALE, asSet("eb", "er", "ide|", "ig", "se",
				"ten", "ti")));
		EXCEPTION_RULES_BY_CHAR.put('u', new LetterExceptionRule('u', Gender.MALE, asSet("d|", "la", "rahim|", "s|")));
		EXCEPTION_RULES_BY_CHAR.put('v', new LetterExceptionRule('v', Gender.MALE, asSet()));
		EXCEPTION_RULES_BY_CHAR.put('w', new LetterExceptionRule('w', Gender.MALE, asSet()));
		EXCEPTION_RULES_BY_CHAR.put('x', new LetterExceptionRule('x', Gender.MALE, asSet()));
		EXCEPTION_RULES_BY_CHAR.put('y', new LetterExceptionRule('y', Gender.MALE, asSet("am", "ana", "anoi", "cal", "cara|",
				"cari|", "carod", "cav", "cira", "clao", "cn", "cren", "cu", "dal", "deh", "elrih", "enar", "g", "ha",
				"htor", "lat", "lea", "lecu", "leg", "lek", "len", "les", "leu", "lev", "lez", "lia", "lir", "lle", "lram",
				"mat", "nai", "nari", "nas", "nau", "navl", "naw", "neg", "nel", "neu", "nna", "nom", "ram", "remi",
				"rems", "ri", "ror", "si", "so", "su", "t")));
		EXCEPTION_RULES_BY_CHAR.put('z', new LetterExceptionRule('z', Gender.MALE, asSet("eni|", "enir", "ered", "il",
				"ir", "u")));

	}

	private static Set<String> asSet(String... s) {
		if (s.length == 0) {
			return Collections.emptySet();
		}
		return new HashSet<>(Arrays.asList(s));
	}

	private static String removeLastChar(String s) {
		return s.substring(0, s.length() - 1);
	}

	private String removeAccents(String original) {
		original = Normalizer.normalize(original, Normalizer.Form.NFD);
		original = original.replaceAll("[^\\p{ASCII}]", "");
		return original;
	}

	private char lastChar(String s) {
		return s.charAt(s.length() - 1);
	}

	private String sanitize(String firstName) {
		return removeAccents(firstName.trim().toLowerCase());
	}

	private String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	private String extractFirstName(String fullName) {
		fullName = sanitize(fullName);
		return fullName.contains(" ") ? fullName.substring(0, fullName.indexOf(" ")) : fullName;
	}

	public Integer recognizeFullNameAvoidException(String fullName) {
		try {
			return recognizeFullName(fullName);
		} catch (Exception e) {
			return null;
		}
	}

	public int recognizeFullName(String fullName) {
		if (fullName == null) {
			throw new IllegalArgumentException("Please provide the full name");
		}
		return recognizeFirstName(extractFirstName(fullName));
	}

	public Integer recognizeFirstNameAvoidException(String firstName) {
		try {
			return recognizeFirstName(firstName);
		} catch (Exception e) {
			return null;
		}
	}

	public int recognizeFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("Please provide the first name");
		}
		firstName = sanitize(firstName);
		if (firstName.length() == 0) {
			throw new IllegalArgumentException("Please provide a correct first name");
		}
		if (firstName.contains(" ")) {
			throw new IllegalArgumentException("Please provide ONLY the first name");
		}

		final char lastChar = lastChar(firstName);
		final LetterExceptionRule exceptionRule = EXCEPTION_RULES_BY_CHAR.get(lastChar);
		final String search = reverse(removeLastChar(firstName)) + "|";

		final int i = exceptionRule.hasException(search) ?
				exceptionRule.defaultGender.inverse().getIdentifier() : exceptionRule.defaultGender.getIdentifier();
		return i;
	}

	private enum Gender {
		MALE(1),
		FEMALE(0);

		final int identifier;

		Gender(int identifier) {
			this.identifier = identifier;
		}

		public int getIdentifier() {
			return identifier;
		}

		public Gender inverse() {
			return this == MALE ? FEMALE : MALE;
		}
	}

	private static class LetterExceptionRule {
		private final char letter;
		private final Gender defaultGender;
		private final Set<String> terminations;

		private LetterExceptionRule(char letter, Gender defaultGender, Set<String> terminations) {
			this.letter = letter;
			this.defaultGender = defaultGender;
			this.terminations = terminations;
		}

		private boolean hasException(String search) {
			if (search.length() == 0) {
				return false;
			}
			if (this.terminations.contains(search)) {
				return true;
			}
			return hasException(removeLastChar(search));
		}
	}

}
