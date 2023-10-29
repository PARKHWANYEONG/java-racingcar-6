package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static racingcar.constants.RacingCarGameConstants.MAX_NAME_LENGTH;
import static racingcar.constants.RacingCarGameConstants.MIN_NAME_LENGTH;
import static racingcar.constants.ValidatorConstants.*;

public class Validator {

    public static void inputCarNames(String[] carNameArr) {
        if (hasDuplicates(carNameArr)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
        for (String carName : carNameArr) {
            if (hasWhitespace(carName)) {
                throw new IllegalArgumentException(HAS_WHITE_SPACE_ERROR_MESSAGE);
            }
            if (isInvalidLength(carName)) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private static boolean hasWhitespace(String carName) {
        return carName.contains(WHITE_SPACE);
    }

    private static boolean isInvalidLength(String carName) {
        return !(MIN_NAME_LENGTH <= carName.length() && carName.length() <= MAX_NAME_LENGTH);
    }

    private static boolean hasDuplicates(String[] carNameArr) {
        List<String> carNameList = arrayToList(carNameArr);
        HashSet<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() != carNameList.size();
    }

    private static List<String> arrayToList(String[] carNameArr) {
        return Arrays.stream(carNameArr).toList();
    }

    public static void isInteger(String attemptCount) {
        try {
            Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_INPUT_ERROR_MESSAGE);
        }
    }
}
