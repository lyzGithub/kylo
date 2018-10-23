import BroadcastService from "./broadcast-service";


import { Injectable, Inject } from "@angular/core";
import "./module"; 

@Injectable()
export default class AddButtonService {
    addButtons: any = {};
    NEW_ADD_BUTTON_EVENT: any = 'newAddButton';
    HIDE_ADD_BUTTON_EVENT: any = 'hideAddButton';
    SHOW_ADD_BUTTON_EVENT: any = 'showAddButton';
    
    constructor( @Inject("BroadcastService") private broadcastService: BroadcastService) { }
    AddButtonServiceTag() { }

    //__tag = new AddButtonServiceTag();
    __tag = this.AddButtonServiceTag();

    registerAddButton (state: any, action: any) {
        this.addButtons[state] = action;
        this.broadcastService.notify(this.NEW_ADD_BUTTON_EVENT, state);
    }
    hideAddButton () {
        this.broadcastService.notify(this.HIDE_ADD_BUTTON_EVENT);
    }
    showAddButton () {
        this.broadcastService.notify(this.SHOW_ADD_BUTTON_EVENT);
    }
    isShowAddButton (state: any) {
        return this.addButtons[state] != undefined;
    }
    unregisterAddButton (state: any) {
        this.addButtons[state];
    }
    onClick (state: any) {
        var action = this.addButtons[state];
        if (action) {
            action();
        }
    }
}