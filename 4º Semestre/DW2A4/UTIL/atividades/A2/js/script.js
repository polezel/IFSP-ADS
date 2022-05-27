const Modal = {
    Open() {
        document.querySelector('.modal-overlay').classList.add('active')
    },
    Close() {
        document.querySelector('.modal-overlay').classList.remove('active')
    }
}