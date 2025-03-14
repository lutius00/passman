const { app, BrowserWindow } = require('electron');
const { spawn } = require('child_process');
const path = require('path');

let backendProcess;
let mainWindow;

app.on('ready', () => {
    // Start the Spring Boot backend
    backendProcess = spawn('java', ['-jar', path.join(__dirname, 'myapp.jar')]);

    backendProcess.stdout.on('data', (data) => {
        console.log(`Backend: ${data}`);
    });

    backendProcess.stderr.on('data', (data) => {
        console.error(`Backend Error: ${data}`);
    });

    // Create the Electron window
    mainWindow = new BrowserWindow({
        width: 1200,
        height: 800,
        webPreferences: {
            nodeIntegration: false // Keep security in mind
        }
    });

    // Load the Spring Boot frontend
    setTimeout(() => {
        mainWindow.loadURL('http://localhost:8080'); // Change port if needed
    }, 3000); // Give the backend some time to start

    mainWindow.on('closed', () => {
        if (backendProcess) backendProcess.kill();
    });
});

app.on('window-all-closed', () => {
    if (backendProcess) backendProcess.kill();
    app.quit();
});
