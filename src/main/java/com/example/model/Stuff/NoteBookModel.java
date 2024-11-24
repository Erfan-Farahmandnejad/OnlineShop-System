package com.example.model.Stuff;

public class NoteBookModel extends StationeryModel {
    private final int pageNumbers;
    private final String paperKind;

    public NoteBookModel(String stuffName, double stuffPrice, int stuffInventory, String madeCountry, int pageNumbers, String paperKind) {
        super(stuffName, stuffPrice, stuffInventory, madeCountry);
        this.pageNumbers = pageNumbers;
        this.paperKind = paperKind;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public String getPaperKind() {
        return paperKind;
    }

    @Override
    public String toString() {
        return super.toString()+" Stuff type:NoteBook " +
                "pageNumbers=" + pageNumbers +
                ", paperKind='" + paperKind + '\''
                ;
    }
}
