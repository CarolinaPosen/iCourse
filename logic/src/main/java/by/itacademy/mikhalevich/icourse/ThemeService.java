package by.itacademy.mikhalevich.icourse;

import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Theme;

import java.util.Map;
import java.util.Optional;

public interface ThemeService {
    Map<Integer, Theme> readTheme();
    Optional<Theme> updateTheme(Theme theme);
    Optional<Theme> createTheme(Theme theme);
    Optional<Theme> deleteTheme(Integer id);
    Optional<Theme> getThemeById (Integer id);
}
