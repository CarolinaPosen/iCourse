package by.itacademy.mikhalevich.icourse;

import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Theme;

import java.util.Map;

public interface ThemeService {
    Map<Integer, Theme> readTheme();
    Map<Integer, Theme> updateTheme(Theme theme);
    Map<Integer, Theme> createTheme(Theme theme);
    Map<Integer, Theme> deleteTheme(Integer id);
    Theme getThemeById (Integer id);
}
