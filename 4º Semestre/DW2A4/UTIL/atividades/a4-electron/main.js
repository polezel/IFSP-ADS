const { app, BrowserWindow, Menu } = require('electron')

const createWindow = () => {
    const mainWindow = new BrowserWindow({ width: 800, height: 600 })
    mainWindow.loadFile('index.html')
}

app.whenReady().then(() => {
    createWindow()
    setMainMenu()

    app.on('activate', () => {
        if (BrowserWindow.getAllWindows().length === 0) createWindow()
    })
})

app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') app.quit()
})

function setMainMenu() {
    const template = [
        {
            label: 'Vizualizar',
            submenu: [
                { role: 'reload' },
                { role: 'toggledevtools' },
                { type: 'separator' },
                { role: 'resetzoom' },
                { type: 'separator' }
            ]
        },
        {
            label: 'Janela',
            role: 'window',
            submenu: [
                { role: 'minimize' },
                { role: 'close' }
            ]
        }
    ];

    const menu = Menu.buildFromTemplate(template)
    Menu.setApplicationMenu(menu)
}

