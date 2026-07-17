# Run tests with Allure reporting and auto-open report
Write-Host "============================================" -ForegroundColor Cyan
Write-Host "Running Tests with Allure Reporting..." -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan

# Clean previous results
Remove-Item -Path "target\allure-results" -Recurse -Force -ErrorAction SilentlyContinue

# Run Maven tests
mvn clean test

# Generate Allure report
Write-Host "`nGenerating Allure Report..." -ForegroundColor Yellow
mvn allure:report

# Open the report in default browser
$reportPath = "target\site\allure-maven-plugin\index.html"
if (Test-Path $reportPath) {
    Write-Host "Opening Allure Report in Browser..." -ForegroundColor Green
    mvn allure:serve
} else {
    Write-Host "Report not found at $reportPath" -ForegroundColor Red
}
